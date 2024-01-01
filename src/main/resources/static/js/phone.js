function editPhone() {
  var phoneSpan = document.getElementById("phone");
  var editButton = document.querySelector(".edit-button");
  phoneSpan.style.display = "none";
  editButton.style.display = "none";

  var phoneEditContainer = document.createElement("div");
  phoneEditContainer.className = "phone-edit-container";

  var newPhoneInput = document.createElement("input");
  newPhoneInput.type = "text";
  newPhoneInput.id = "newPhoneInput";
  newPhoneInput.placeholder = "Enter new phone: ";

  var saveButton = document.createElement("button");
  saveButton.textContent = "Save";
  saveButton.className = "save-button";
  saveButton.onclick = function () {
    var newPhoneValueInput = document.getElementById("newPhoneInput");
    var newPhoneValue = newPhoneValueInput.value;

    var xhr = new XMLHttpRequest();
    xhr.open("POST", "/account", true);
    xhr.setRequestHeader("Content-Type", "application/json;charset=UTF-8");

    xhr.onreadystatechange = function () {
      if (xhr.readyState == XMLHttpRequest.DONE) {
        if (xhr.status == 200) {
          console.log("Controller'a başarıyla gönderildi");
          location.reload();
          phoneEditContainer.remove();
        } else {
          console.error("Hata oluştu:", xhr.responseText);
        }
      }
    };

    xhr.send(encodeURIComponent(newPhoneValue));
  };

  var cancelButton = document.createElement("button");
  cancelButton.textContent = "Cancel";
  cancelButton.className = "cancel-button";
  cancelButton.onclick = function () {
    phoneSpan.style.display = "inline";
    editButton.style.display = "inline";
    phoneEditContainer.remove();
  };

  phoneEditContainer.appendChild(newPhoneInput);
  phoneEditContainer.appendChild(saveButton);
  phoneEditContainer.appendChild(cancelButton);

  phoneSpan.parentNode.replaceChild(phoneEditContainer, phoneSpan);
}
