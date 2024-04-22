let contenedor = ['ai', 'enter', 'imes', 'ober', 'ufat'];
let caracteresEspeciales = /[^\w\sñ]/g;
let numeros = /\d/g;
let enviar = document.querySelector('.enviar');
enviar.addEventListener('click', function () {
  let input = document.querySelector('.input');
  let inputLower = input.value.toLowerCase();
  let resultado = document.querySelector('.resultado');
  let areaOutput = document.querySelector('.area-output');
  let newInput = '';
  if (
    inputLower === input.value &&
    !caracteresEspeciales.test(input.value) &&
    !numeros.test(input.value)
  ) {
    for (let i = 0; i < input.value.length; i++) {
      if (input.value[i] === 'a') {
        newInput += contenedor[0];
      } else if (input.value[i] === 'e') {
        newInput += contenedor[1];
      } else if (input.value[i] === 'i') {
        newInput += contenedor[2];
      } else if (input.value[i] === 'o') {
        newInput += contenedor[3];
      } else if (input.value[i] === 'u') {
        newInput += contenedor[4];
      } else {
        newInput += input.value[i];
      }
    }
    if (input.value !== '') {
      resultado.innerHTML = newInput;
      areaOutput.style.backgroundImage = 'none';
    }
  } else {
    alert('Solo se aceptan letras minúsculas y sin caracteres especiales');
  }
});

let reset = document.querySelector('.reset');
reset.addEventListener('click', function () {
  let input = document.querySelector('.input');
  let resultado = document.querySelector('.resultado');
  let areaOutput = document.querySelector('.area-output');
  input.value = '';
  resultado.innerHTML = '';
  areaOutput.style.backgroundImage = 'url("fondo.png")';
});

function updateClipboard() {
  let resultado = document.querySelector('.resultado');
  navigator.clipboard.writeText(resultado.innerHTML).then(() => {
    alert('Copiado al portapapeles');
  });
}

let copiar = document.querySelector('.copiar');
copiar.addEventListener('click', updateClipboard);

let desencriptar = document.querySelector('.desencriptar');
desencriptar.addEventListener('click', function () {
  let input = document.querySelector('.input');
  let inputLower = input.value.toLowerCase();
  let resultado = document.querySelector('.resultado');
  let areaOutput = document.querySelector('.area-output');
  let newInput = '';
  let i = 0;
  if (inputLower === input.value && !caracteresEspeciales.test(input.value)) {
    while (i < input.value.length) {
      if (input.value[i] === 'a' && input.value[i + 1] === 'i') {
        newInput += 'a';
        i += 2;
      } else if (input.value.substring(i, i + 5) === 'enter') {
        newInput += 'e';
        i += 5;
      } else if (input.value.substring(i, i + 4) === 'imes') {
        newInput += 'i';
        i += 4;
      } else if (input.value.substring(i, i + 4) === 'ober') {
        newInput += 'o';
        i += 4;
      } else if (input.value.substring(i, i + 4) === 'ufat') {
        newInput += 'u';
        i += 4;
      } else {
        newInput += input.value[i];
        i++;
      }
    }
    resultado.innerHTML = newInput;
    areaOutput.style.backgroundImage = 'none';
  } else {
    alert('Solo se aceptan letras minúsculas y sin caracteres especiales');
  }
});
