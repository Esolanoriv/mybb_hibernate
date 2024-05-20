document.querySelector('form[action="registroTomas"]').addEventListener('submit', async function(event) {
  event.preventDefault();
  await enviar_formulario_registro_tomas();
});

async function enviar_formulario_registro_tomas() {
  var id_usuario_bebe = document.querySelector("input[name='idUsuarioBebe']").value.trim();
  var fecha_hora_toma = document.getElementById("inputFechaHoraToma").value.trim();
  var estado_bebe = document.getElementById("inputEstadoBebe").value;
  var cantidad_leche_consumida = document.getElementById("inputCantidadLecheConsumida").value.trim();
  var duracion_toma = document.getElementById("inputDuracionToma").value.trim();
  var tipo_formula = document.getElementById("inputTipoFormula").value;
  var marca_formula = document.getElementById("inputMarcaFormula").value.trim();
  var colico_asociado = document.getElementById("inputColicoAsociado").value;

  var tipo_colico = "";
  var intensidad_llanto = "";
  var duracion_colico = "";
  var fecha_hora_inicio_colico = "";
  var medicacion_colico = "";
  var marca_medicacion = "";

  if (colico_asociado === "Si") {
      tipo_colico = document.getElementById("inputTipoColico").value;
      intensidad_llanto = document.getElementById("inputIntensidadLlanto").value;
      duracion_colico = document.getElementById("inputDuracionColico").value.trim();
      fecha_hora_inicio_colico = document.getElementById("inputFechaHoraInicioColico").value.trim();
      medicacion_colico = document.getElementById("inputMedicacionColico").value;
      marca_medicacion = document.getElementById("inputMarcaMedicacion").value.trim();
  }

  if (
      fecha_hora_toma === "" || cantidad_leche_consumida === "" || duracion_toma === "" ||
      marca_formula === "" || (colico_asociado === "Si" && (
          tipo_colico === "" || duracion_colico === "" || fecha_hora_inicio_colico === "" ||
          medicacion_colico === "" || (medicacion_colico === "Si" && marca_medicacion === "")
      ))
  ) {
      mostrar_error_modal("Por favor, completa todos los campos obligatorios.");
      return false;
  }

  const formulario = {
      id_usuario_bebe: id_usuario_bebe,
      fecha_hora_toma: fecha_hora_toma,
      estado_bebe: estado_bebe,
      cantidad_leche_consumida: cantidad_leche_consumida,
      duracion_toma: duracion_toma,
      tipo_formula: tipo_formula,
      marca_formula: marca_formula,
      colico_asociado: colico_asociado,
      tipo_colico: tipo_colico,
      intensidad_llanto: intensidad_llanto,
      duracion_colico: duracion_colico,
      fecha_hora_inicio_colico: fecha_hora_inicio_colico,
      medicacion_colico: medicacion_colico,
      marca_medicacion: marca_medicacion
  };

  try {
      const response = await fetch("registroTomas", {
          method: "POST",
          headers: {
              "Content-Type": "application/json"
          },
          body: JSON.stringify(formulario)
      });

      if (response.ok) {
          mostrar_exito_modal("Toma de leche registrada correctamente.");
          limpiar_formulario();
      } else {
          mostrar_error_modal("Error al registrar la toma de leche.");
      }
  } catch (error) {
      console.error("Error al enviar la solicitud:", error);
      mostrar_error_modal("Error de red al enviar la solicitud.");
  }
}

function limpiar_formulario() {
  document.getElementById("inputFechaHoraToma").value = "";
  document.getElementById("inputEstadoBebe").value = "Relajado";
  document.getElementById("inputCantidadLecheConsumida").value = "";
  document.getElementById("inputDuracionToma").value = "";
  document.getElementById("inputTipoFormula").value = "Normal";
  document.getElementById("inputMarcaFormula").value = "";
  document.getElementById("inputColicoAsociado").value = "No";
  document.getElementById("formularioColicos").style.display = "none";
  document.getElementById("inputTipoColico").value = "Reflujo";
  document.getElementById("inputIntensidadLlanto").value = "Leve";
  document.getElementById("inputDuracionColico").value = "";
  document.getElementById("inputFechaHoraInicioColico").value = "";
  document.getElementById("inputMedicacionColico").value = "No";
  document.getElementById("inputMarcaMedicacion").value = "";
}

// function mostrar_error_modal(mensaje) {
//   var myModal = new bootstrap.Modal(document.getElementById('errorModal'));
//   document.getElementById('errorModalBody').innerText = mensaje;
//   myModal.show();
// }

// function mostrar_exito_modal(mensaje) {
//   var myModal = new bootstrap.Modal(document.getElementById('successModal'));
//   document.getElementById('successModalBody').innerText = mensaje;
//   myModal.show();
// }

// document.getElementById("inputColicoAsociado").addEventListener("change", function() {
//   var formularioColicos = document.getElementById("formularioColicos");
//   formularioColicos.style.display = (this.value === "Si") ? "block" : "none";
// });
