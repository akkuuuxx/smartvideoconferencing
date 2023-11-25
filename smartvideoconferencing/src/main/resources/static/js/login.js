function handleLogin(event) {
    event.preventDefault();
    // Get user input
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    console.log(email);
    //create a user object
    const user = {
        email: email,
        password: password
    };

    //send login api call

    fetch('http://localhost:8081/app/login', 
    {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    })
        .then(res => {
          return res.json();
        })
        .then(data=>{
           
           if(data.errorCode===400){
            console.log(data.message);
            document.getElementById('errorMsg').innerHTML=data.message
           }
           else {
            localStorage.setItem('connectedUser',JSON.stringify(data));
            window.location.href = 'index.html';
        }
        }).catch(err=>{
            console.error("Post Request Error",err);
        })
}



const loginForm = document.getElementById("loginForm");
loginForm.addEventListener("submit", handleLogin);
