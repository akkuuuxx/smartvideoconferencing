function handleRegister(event) {
    event.preventDefault();
    // Get user input
    const name=document.getElementById("name").value;
    const username=document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password=document.getElementById("password").value;
    const dateofbirth = document.getElementById("dateofbirth").value;

   console.log(typeof dateofbirth); 
    console.log(email);
    console.log(dateofbirth);
    console.log(username);
    console.log(password);
    console.log(name);
    //create a user object
    const user = {
        email: email,
        username:username,
        password:password,
        dateofbirth: dateofbirth,
        name:name
    };

    //send login api call

    fetch('http://localhost:8081/app/register', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(user)
    }).then(res => {
          return res.json();
        })
        .then(data=>{
           console.log(data)
           if(data.errorCode===400){
            console.log(data);
            document.getElementById('errorMsg').innerHTML=data.message
        }
        }).catch(error=>{
            document.getElementById('errorMsg').innerHTML=`${name} is successfully registered !!!`
        })
    }

const registerForm = document.getElementById("registerForm");
registerForm.addEventListener("submit", handleRegister)