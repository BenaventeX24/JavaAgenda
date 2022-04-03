function retrieveDataRegister(){
  var name = document.getElementById('name').value;
  var number = (document.getElementById('num').value);
  var mail = document.getElementById('mail').value;

  var data = new Object();
  data.name = name;
  data.number = number;
  data.mail = mail;

  register(data);
}

async function register(data) {
  return await fetch("http://localhost:8080/register", {
    method: "POST",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
    body: JSON.stringify(data)
  }).then(function (response) {
    if (response.ok) {
      document.getElementById("response").innerHTML = `
                <div id="responseBox">
                <h1>Contact registered</h1>
                </div>`;
    }
  });
}

async function search(name) {
  return await fetch("http:localhost:8080/search?name=" + name, {
    method: "GET",
    mode: "cors",
    headers: {
      "Content-Type": "application/json",
    },
  })
    .then((response) => response.json())
    .then((data) => {
      if (data == "") {
        document.getElementById("response").innerHTML = `
                <div id="responseBox">
                <h1>Contact not found</h1>
                </div>`;
      }else{
      document.getElementById("response").innerHTML = `
      <div id="responseBox">
      <h1>Contact Found</h1>
      <h2>${data.name}</h2>
      <p class="responseInfo">${data.number}</p>
      <p class="responseInfo">${data.mail}</p>
      </div>`
      }
    });
}
