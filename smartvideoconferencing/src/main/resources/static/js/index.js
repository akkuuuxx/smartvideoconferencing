const connectedUser = localStorage.getItem("connectedUser");
function loadOnlineUsers() {
  const connectedUser = localStorage.getItem("connectedUser");
  if (!connectedUser) {
    window.location = "login.html";
    return;
  }
  //changing title on index page
  document.getElementById("title").innerHTML = `Welcome ${
    JSON.parse(connectedUser).name
  }`;

  setInterval(() => {
    fetch("http://localhost:8081/app/allusers")
    .then((data) => {
      return data.json(); //convert to object
    })
    .then((objectData) => {
      console.log(objectData[0].username);

      let tableData = "";
      objectData.map((values) => {
        tableData += `<tr>
            <th>${values.username}</th>
            <th>${values.email}</th>
            <th>${values.status}</th>
          </tr>`;
      });
      document.getElementById("table_body").innerHTML = tableData;
    })
    .catch((error) => {
      console.log("Get request error", error);
    });
  }, 2000);
 
}
loadOnlineUsers();

// function for logging out user
function handleLogout() {
  fetch(
    `http://localhost:8081/app/logout/${JSON.parse(connectedUser).email}/${
      JSON.parse(connectedUser).password
    }`
  )
    .then((data) => {
      return data.text();
    })
    .then((userData) => {
      console.log(userData);
      localStorage.removeItem("connectedUser");
      window.location.href = "login.html";
    })
    .catch((error) => {
      console.log(`Post request error`, error);
    });
}

const logoutBtn = document.getElementById("logoutBtn");
logoutBtn.addEventListener("click", handleLogout);

//function for creating new meeting

function handleNewMeeting() {
  console.log("New meeting button");
  const connectedUser = JSON.parse(localStorage.getItem("connectedUser"));
  window.open(`videocall.html?username=${connectedUser.username}`, "_blank");
}

// Attach the handleNewMeeting function to the "Create a New Meeting" button
const newMeetingBtn = document.getElementById("newMeetingBtn");
newMeetingBtn.addEventListener("click", handleNewMeeting);

//method for join meetin via code

function handleJoinMeeting() {
  const roomId = document.getElementById("meetingId").value;
  const connectedUser = JSON.parse(localStorage.getItem("connectedUser"));

  const url = `videocall.html?roomID=${roomId}&username=${connectedUser.username}`;

  window.open(url, "_blank");
}

const joinBtn = document.getElementById("joinBtn");
joinBtn.addEventListener("click", handleJoinMeeting);
