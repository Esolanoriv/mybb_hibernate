async function enviarFormularioInicioSesion() {
    const username = document.getElementById("username").value;
    const password = document.getElementById("password").value;

    try {
        const respuesta = await enviarDatosInicioSesion(username, password);
        console.log(respuesta);
        // Manejar la respuesta según sea necesario (por ejemplo, redireccionar o mostrar un mensaje)
    } catch (error) {
        console.error("Error al enviar el formulario de inicio de sesión:", error);
        // Manejar el error según sea necesario
    }
}

async function obtenerBebes() {
   

    try {
        const response = await fetch("/bebes", {
            method: "GET",
            headers: {
                "Content-Type": "application/json"
            }
        });
        const data = await response.json();
        return data;
    } catch (error) {
        console.error("Error al enviar la solicitud GET:", error);
        throw error;
    }
    
}
