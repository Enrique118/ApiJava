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
                    profesoresList.appendChild(div);
                });
            });
    }

    if (inscripcionForm) {
        inscripcionForm.addEventListener('submit', (event) => {
            event.preventDefault();
            const formData = new FormData(inscripcionForm);
            const alumnoData = {
                Nombre: formData.get('Nombre'),
                Correo: formData.get('Correo'),
                idPago: formData.get('idPago'),
                noTelefono: formData.get('noTelefono')
            };

            console.log(alumnoData);


            fetch('http://localhost:4000/alumno', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(alumnoData)
            })
            .then(response => {
                if (!response.ok) {
                    throw new Error('Error en la respuesta de la red');
                }
                return response.json();
            })
            .then(data => {
                alert('Alumno inscrito con éxito');
                inscripcionForm.reset();
            })
            .catch(error => {
                console.error('Error:', error);
            });
        });
    } else {
        console.error('Formulario de inscripción no encontrado');
    }

    obtenerTemarios();
    obtenerProfesores();
});

