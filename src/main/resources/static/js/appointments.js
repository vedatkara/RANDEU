

let cardHTML = ` `;
appointments.forEach((appointment) => {
    cardHTML += `
        <div class="card-container">
        <div class="card">
            <div class="card-inner">
                <p class="appointment-date-text js-appointment-date-text">${appointment.getDat}</p>
                <p class="lecturer-name js-lecturer-name">${appointment.getLecturerId.getName} 
                ${appointment.getLecturerId.getSurname}</p>
                <p class="address js-address">${appointment.getAddressId.getFaculty} ${appointment.getAddressId.getRoomNo}</p>
            </div>
        </div>
    </div>
    `;
});