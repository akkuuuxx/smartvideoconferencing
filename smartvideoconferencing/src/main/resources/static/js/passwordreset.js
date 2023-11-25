function handleReset(event) {
    event.preventDefault();
    // Get user input
    const email = document.getElementById("email").value;
    const dateofbirth = document.getElementById("dateofbirth").value;

    console.log(email);
    console.log(dateofbirth);
    //create a user object
    const user = {
        email: email,
        dateofbirth: dateofbirth
    };

    //send login api call

    fetch('http://localhost:8081/app/resetpassword', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(res => {
          return res.json();
        })
        .then(data=>{
           
           if(data.errorCode===400){
            console.log(data.message);
            document.getElementById('errorMsg').innerHTML=data.message
           }
           else {
            document.getElementById('errorMsg').innerHTML=`Your password is = ${data.password} `;
        }
        }).catch(err=>{
            console.error("Post Request Error",err);
        })
    }

const resetForm = document.getElementById("resetForm");
resetForm.addEventListener("submit", handleReset);