document.addEventListener('DOMContentLoaded', () => {
    const alumnosList = document.getElementById('alumnos-list');

    function obtenerAlumnos() {
        fetch('http://localhost:3000/alumnos')
            .then(response => response.json())
            .then(data => {
                data.forEach(alumno => {
                    const row = document.createElement('tr');

                    const cellId = document.createElement('td');
                    cellId.textContent = alumno.id;
                    row.appendChild(cellId);

                    const cellNombre = document.createElement('td');
                    cellNombre.textContent = alumno.nombre;
                    row.appendChild(cellNombre);

                    const cellCorreo = document.createElement('td');
                    cellCorreo.textContent = alumno.correo;
                    row.appendChild(cellCorreo);

                    const cellTelefono = document.createElement('td');
                    cellTelefono.textContent = alumno.no_telefono;
                    row.appendChild(cellTelefono);

                    const cellIdPago = document.createElement('td');
                    cellIdPago.textContent = alumno.id_pago;
                    row.appendChild(cellIdPago);

                    alumnosList.appendChild(row);
                });
            });
    }

    obtenerAlumnos();
});
