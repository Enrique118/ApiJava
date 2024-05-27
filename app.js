document.addEventListener('DOMContentLoaded', () => {
    const alumnosList = document.getElementById('alumnos-list');

    function obtenerAlumnos() {
        fetch('http://localhost:4000/alumno')
            .then(response => response.json())
            .then(data => {
                data.forEach(alumno => {
                    const row = document.createElement('tr');

                    const cellNombre = document.createElement('td');
                    cellNombre.textContent = alumno.Nombre; // Asegúrate de que coincide con el campo JSON
                    row.appendChild(cellNombre);

                    const cellCorreo = document.createElement('td');
                    cellCorreo.textContent = alumno.Correo; // Asegúrate de que coincide con el campo JSON
                    row.appendChild(cellCorreo);

                    const cellTelefono = document.createElement('td');
                    cellTelefono.textContent = alumno.noTelefono; // Asegúrate de que coincide con el campo JSON
                    row.appendChild(cellTelefono);

                    const cellIdPago = document.createElement('td');
                    cellIdPago.textContent = alumno.idPago; // Asegúrate de que coincide con el campo JSON
                    row.appendChild(cellIdPago);

                    alumnosList.appendChild(row);
                });
            })
            .catch(error => console.error('Error al obtener los alumnos:', error));
    }

    obtenerAlumnos();
});
