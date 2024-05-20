document.getElementById('newUserForm').addEventListener('submit', async function(event) {
  event.preventDefault();
  await enviarFormularioAltaBebe();
});

async function enviarFormularioAltaBebe() {
  var nombre_usuario = document.getElementById("inputnombreUsuario").value.trim();
  var contrasena_usuario = document.getElementById("inputcontrasenaUsuario").value.trim();
  var nombre_bebe = document.getElementById("inputnombreBebe").value.trim();
  var fecha_nacimiento_bebe = document.getElementById("inputfechaNacimientoBebe").value;
  var genero_bebe = document.getElementById("inputgeneroBebe").value;
  var peso_inicial_bebe = document.getElementById("inputpesoInicialBebe").value.trim();
  var altura_inicial_bebe = document.getElementById("inputalturaInicialBebe").value.trim();
  var semana_gestacion_bebe = document.getElementById("inputsemanagestacionBebe").value.trim();
  var observaciones_bebe = document.getElementById("inputobservacionesBebe").value.trim();

  if (
    nombre_usuario === "" || contrasena_usuario === "" || nombre_bebe === "" || 
    fecha_nacimiento_bebe === "" || genero_bebe === "" || peso_inicial_bebe === "" || 
    altura_inicial_bebe === "" || semana_gestacion_bebe === ""
  ) {
    mostrarErrorModal("Por favor, completa todos los campos.");
    return false;
  }

  const bebeModelo = {
    nombre_usuario: nombre_usuario,
    contrasena_usuario: contrasena_usuario,
    nombre_bebe: nombre_bebe,
    fecha_nacimiento_bebe: fecha_nacimiento_bebe,
    genero_bebe: genero_bebe,
    peso_inicial_bebe: peso_inicial_bebe,
    altura_inicial_bebe: altura_inicial_bebe,
    semana_gestacion_bebe: semana_gestacion_bebe,
    observaciones_bebe: observaciones_bebe
  };

  try {
    const response = await fetch("/nuevoBebe", {
        method: "POST",
        headers: {
            "Content-Type": "application/json"
        },
        body: JSON.stringify(bebeModelo)
    });

    if (response.ok) {
        mostrarExitoModal("Usuario registrado correctamente.");
        localStorage.setItem("nombre_usuario", nombre_usuario);
        window.location.href = 'usuarioRegistrado.html';
    } else if (response.status == 400) {
        const message = await response.text();
        mostrarErrorModal(message || "El Usuario ya existe.");
    } else if (response.status == 500) {
        mostrarErrorModal("Error al enviar la solicitud.");
    }
  } catch (error) {
    console.error("Error al enviar la solicitud:", error);
    mostrarErrorModal("Error de red al enviar la solicitud.");
  }
}

function mostrarExitoModal(mensaje) {
  var myModal = new bootstrap.Modal(document.getElementById('successModal'));
  document.getElementById('successModalLabel').innerText = "¡Éxito!";
  document.getElementById('successModalBody').innerText = mensaje;
  myModal.show();
}

function mostrarErrorModal(mensaje) {
  var myModal = new bootstrap.Modal(document.getElementById('errorModal'));
  document.getElementById('errorModalBody').innerText = mensaje;
  myModal.show();
}
