document.addEventListener('DOMContentLoaded', () => {
    const alumnosList = document.getElementById('alumnos-list');

    function obtenerAlumnos() {
        fetch('http://localhost:4000/alumno')
            .then(response => response.json())
            .then(data => {
                data.forEach(alumno => {
                    const row = document.createElement('tr');

                    const cellNombre = document.createElement('td');
                    cellNombre.textContent = alumno.Nombre;
                    row.appendChild(cellNombre);

                    const cellCorreo = document.createElement('td');
                    cellCorreo.textContent = alumno.Correo;
                    row.appendChild(cellCorreo);

                    const cellTelefono = document.createElement('td');
                    cellTelefono.textContent = alumno.No_telefono;
                    row.appendChild(cellTelefono);

                    const cellIdPago = document.createElement('td');
                    cellIdPago.textContent = alumno.Id_pago;
                    row.appendChild(cellIdPago);

                    alumnosList.appendChild(row);
                });
            })
            .catch(error => console.error('Error al obtener los alumnos:', error));
    }

    obtenerAlumnos();
});
