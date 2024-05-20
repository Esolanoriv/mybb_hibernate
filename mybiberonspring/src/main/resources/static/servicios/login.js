async function enviarFormularioInicioSesion() {
    const nombre_usuario = document.getElementById("username").value;
    const contrasena_usuario = document.getElementById("password").value;

    try {
        const respuesta = await enviarDatosInicioSesion(nombre_usuario, contrasena_usuario);
        if (respuesta) {
            //guardamos sesion en localstorage
            localStorage.setItem("nombre_usuario", nombre_usuario);
            // Si la respuesta es true, redirige al usuario a la página de registrosDeAlimentacion.html
            window.location.href = "/usuarioRegistrado.html";
        } else {
            // Si la respuesta es false, muestra un mensaje de error
            mostrarMensaje("Credenciales incorrectas, intenta de nuevo.", "alert-danger");
        }
    } catch (error) {
        console.error("Error al enviar el formulario de inicio de sesión:", error);
        // Manejar el error según sea necesario
    }
}

function mostrarMensaje(mensaje, clase) {
    const mensajeElemento = document.getElementById("mensaje");
    mensajeElemento.textContent = mensaje;
    mensajeElemento.classList.add(clase);
    mensajeElemento.style.display = "block";
}

async function enviarDatosInicioSesion(nombre_usuario, contrasena_usuario) {
    const formData = {
        nombre_usuario: nombre_usuario,
        contrasena_usuario: contrasena_usuario
    };

    try {
        const response = await fetch("/existeBebe", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        });
        const data = await response.json();
        return data; // Devuelve true o false
    } catch (error) {
        console.error("Error al enviar el formulario de inicio de sesión:", error);
        throw error;
    }
}

async function obtenerBebes() {
    
    try {
        const response = await fetch("/login", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(formData)
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error("Error al enviar el formulario de inicio de sesión:", error);
        throw error;
    }
}
