document.addEventListener('DOMContentLoaded', () => {
    const temarioList = document.getElementById('temario-list');
    const profesoresList = document.getElementById('profesores-list');
    const inscripcionForm = document.getElementById('inscripcion-form');

    function obtenerTemarios() {
        fetch('http://localhost:4000/temario')
            .then(response => response.json())
            .then(data => {
                data.forEach(temario => {
                    const div = document.createElement('div');
                    div.textContent = `Año: ${temario.anio}, Estatus: ${temario.estatus}, Temas: ${temario.temas}, Objetivo: ${temario.objetivo}`;
                    temarioList.appendChild(div);
                });
            });
    }

    function obtenerProfesores() {
        fetch('http://localhost:4000/profesor')
            .then(response => response.json())
            .then(data => {
                data.forEach(profesor => {
                    const div = document.createElement('div');
                    div.textContent = `Nombre: ${profesor.nombre}, Correo: ${profesor.correo}, Teléfono: ${profesor.telefono}`;
                    instructoresList.appendChild(div);
                });
            });
    }

    inscripcionForm.addEventListener('submit', (event) => {
        event.preventDefault();
        const formData = new FormData(inscripcionForm);
        const alumnoData = {
            nombre: formData.get('nombre'),
            correo: formData.get('correo'),
            telefono: formData.get('telefono'),
            id_pago: formData.get('id_pago')
        };

        fetch('http://localhost:4000/alumno', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(alumnoData)
        })
        .then(response => response.json())
        .then(data => {
            alert('Alumno inscrito con éxito');
            inscripcionForm.reset();
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });

    obtenerTemarios();
    obtenerProfesores();
});

