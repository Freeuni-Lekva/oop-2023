window.onload = start;

function start() {
    const button = document.getElementById("submit");
    button.onclick = addStudent;
}

function addStudent() {
    const firstName = document.getElementById("fname").value;
    const lastName = document.getElementById("lname").value;
    const year = document.getElementById("year").value;

    const table = document.getElementById("student-table");

    if (firstName === "" || lastName === "" || year === "") {
        alert("Fields can't be empty!");
        return;
    }

    let row = table.insertRow(-1);
    let firstNameCell = row.insertCell(0);
    firstNameCell.innerHTML = `Mr/Mrs ${firstName}`;

    let lastNameCell = row.insertCell(1);
    lastNameCell.innerHTML = lastName;

    let yearCell = row.insertCell(2);
    yearCell.innerHTML = year;
}
