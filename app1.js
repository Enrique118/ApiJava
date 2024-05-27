document.addEventListener('DOMContentLoaded', function() {
    const form = document.getElementById('inscripcion-form');
    const temarioList = document.getElementById('temario-list');
    const profesoresList = document.getElementById('profesores-list');

    function obtenerTemarios() {
        fetch('http://localhost:3000/temarios')
            .then(response => response.json())
            .then(data => {
                data.forEach(temario => {
                    const div = document.createElement('div');
                    div.textContent = `Año: ${temario.anio}, Estatus: ${temario.estatus}, Temas: ${temario.temas}, Objetivo: ${temario.objetivo}`;
                    temarioList.appendChild(div);
                });
            })
            .catch(error => console.error('Error al obtener temarios:', error));
    }

    function obtenerProfesores() {
        fetch('http://localhost:3000/profesores')
            .then(response => response.json())
            .then(data => {
                data.forEach(profesor => {
                    const div = document.createElement('div');
                    div.textContent = `Nombre: ${profesor.nombre}, Correo: ${profesor.correo}, Teléfono: ${profesor.telefono}`;
                    profesoresList.appendChild(div);
                });
            })
            .catch(error => console.error('Error al obtener profesores:', error));
    }

    form.addEventListener('submit', function(event) {
        event.preventDefault();

        const formData = {
            nombre: document.getElementById('nombre').value,
            correo: document.getElementById('correo').value,
            telefono: document.getElementById('telefono').value,
            id_pago: document.getElementById('id_pago').value
        };

        fetch('http://localhost:3000/alumnos', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formData)
        })
        .then(response => response.json())
        .then(data => {
            console.log('Alumno agregado:', data);
            alert('Alumno inscrito con éxito!');
            form.reset();
        })
        .catch(error => {
            console.error('Error:', error);
        });
    });

    fetch('/categorias')
    .then(response => response.json())
    .then(categorias => {
        const categoriaList = document.getElementById('categoria-list');
        categoriaList.innerHTML = categorias.map(categoria => `
            <tr>
                <td>${categoria.nombre_categoria}</td>
                <td>${categoria.descripcion}</td>
            </tr>
        `).join('');
    })
    .catch(error => console.error('Error al obtener categorías:', error));
 
    fetch('/cursos')
    .then(response => response.json())
    .then(cursos => {
        const cursoList = document.getElementById('curso-list');
        cursoList.innerHTML = cursos.map(curso => `
            <tr>
                <td>${curso.nombre}</td>
                <td>${curso.descripcion}</td>
                <td>${curso.duracion}</td>
            </tr>
        `).join('');
    })
    .catch(error => console.error('Error al obtener cursos:', error));

    obtenerTemarios();
    obtenerProfesores();
});