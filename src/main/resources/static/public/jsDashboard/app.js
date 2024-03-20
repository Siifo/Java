//evento que al dar click en las tres lineas mostrara y ocultara el side-menu

let arrow = document.querySelectorAll(".arrow");
for (var i = 0; i < arrow.length; i++) {
  arrow[i].addEventListener("click", (e) => {
    let arrowParent = e.target.parentElement.parentElement; //selecting main parent of arrow
    arrowParent.classList.toggle("showMenu");
  });
}

let sidebar = document.querySelector(".sidebar");
let sidebarBtn = document.querySelector(".bx-menu");
console.log(sidebarBtn);
sidebarBtn.addEventListener("click", () => {
  sidebar.classList.toggle("close");
});



//formulario pantalla
const form = document.getElementById("form");

const mostrarDashboard = document.getElementById("mostrarDashboard");

const hideDashboard = document.getElementById("dashboard") //oculatar dashboard

//-------------------------- sidebar-modulos -------------\\
//logistica
const registrarEvento = document.getElementById("registrarEvento")
const consultarEvento = document.getElementById("consultarEvento")
const listaEvento = document.getElementById("listaEvento")

const registarEmpleado = document.getElementById("registarEmpleado")
const consultarEmpleado = document.getElementById("consultarEmpleado")

const generarReporteLogistica = document.getElementById("generarReporteLogistica")

//inventario
const registrarProducto = document.getElementById("registrarProducto")
const consultarProducto = document.getElementById("consultarProducto")

const registrarProveedor = document.getElementById("registrarProveedor")
const consultarProveedor = document.getElementById("consultarProveedor")

const generarReporteInventario = document.getElementById("generarReporteInventario")

//ventas
const registrarOV = document.getElementById("registrarOV")
const consultarOV = document.getElementById("consultarOV")

const registrarOC = document.getElementById("registrarOC")
const consultarOC = document.getElementById("consultarOC")

//-------------------------- logistica -------------\
const agregarEvento = document.getElementById("agregarEvento")
const formularioConsultarVenta = document.getElementById("formularioConsultarVenta")
const agregarFormEmpleado = document.getElementById("agregarFormEmpleado")
const formularioConsultarEmpleado = document.getElementById("formularioConsultarEmpleado")

//Registrar evento
registrarEvento.addEventListener("click", function(){
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  agregarEvento.style.display = "block";

  //agregar empleado boton
  const contenedorCampos = document.getElementById("contenedorCampos");
  const agregarEmpleado = document.getElementById("agregarEmpleado");
  let contadorEmpleados = 1;
  let datalistClon;
  let nuevoCampo;
  agregarEmpleado.addEventListener("click", () => {
    contadorEmpleados++;

    nuevoCampo = document.createElement("input");
    nuevoCampo.list = "empleado";
    nuevoCampo.classList = "form-control my-4 py-2 descartarEmpleados";
    nuevoCampo.id = "agregarEmpleados" + contadorEmpleados;
    nuevoCampo.name = "empleado No." + contadorEmpleados;
    nuevoCampo.placeholder = "agrega al empleado " + contadorEmpleados;

    const datalist = document.getElementById("empleado");
    datalistClon = datalist.cloneNode(true);
    datalistClon.setAttribute("class", "removeDatalist")
    nuevoCampo.setAttribute("list", "empleado");

    contenedorCampos.appendChild(nuevoCampo);
    contenedorCampos.appendChild(datalistClon);
  });

  
  //boton eliminar empleado
  const descartarEmpleado = document.getElementById("descartarEmpleado") //este es el boton
  descartarEmpleado.addEventListener("click", ()=> {
    if(contadorEmpleados > 1){
    const ultimoCampo = document.getElementById("agregarEmpleados" + contadorEmpleados);
    contenedorCampos.removeChild(ultimoCampo)
    contadorEmpleados--;
    }
    
  });
})

//consulta evento
consultarEvento.addEventListener("click", function() {
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  formularioConsultarVenta.style.display = "block";
})

//Registrar empleado
registarEmpleado.addEventListener("click", function(){
  hideDashboard.style.display = "none"
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";
  
  agregarFormEmpleado.style.display = "block"
})

//Consultar empleado
consultarEmpleado.addEventListener("click", function(){
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";

  formularioConsultarEmpleado.style.display = "block";
})
//-------------------------- Inventario -------------\
const agregarProducto = document.getElementById("agregarProducto");
const formularioConsultarProducto = document.getElementById("formularioConsultarProducto")
const agregarProveedor = document.getElementById("agregarProveedor");
const formularioConsultarProveedor = document.getElementById("formularioConsultarProveedor")

// registrar producto
registrarProducto.addEventListener("click", function(){
  
  hideDashboard.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none";
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";  
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";
  
  agregarProducto.style.display = "block";
})

// consultar Producto
consultarProducto.addEventListener("click", function(){
  hideDashboard.style.display = "none";
  agregarProveedor.style.display = "none";
  agregarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none";
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  formularioConsultarProducto.style.display = "block";
})

// Registrar Proveedor

registrarProveedor.addEventListener("click", function(){
  
  agregarProducto.style.display = "none";
  hideDashboard.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none";
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";
  
  agregarProveedor.style.display = "block";
})

consultarProveedor.addEventListener("click", function(){
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  formularioConsultarProveedor.style.display = "block";  
})



//-------------------------- Ventas -------------\
const agregarOrdenVenta = document.getElementById("agregarOrdenVenta")
const formularioConsultarOV = document.getElementById("formularioConsultarOV")
const agregarRegistroCompra = document.getElementById("agregarRegistroCompra")
const formularioConsultarOC = document.getElementById("formularioConsultarOC")

//Rregistrar orden de venta
registrarOV.addEventListener("click", function(){
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  agregarOrdenVenta.style.display = "block";
})

//Consultar orden venta
consultarOV.addEventListener("click", function(){
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none"; 
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  formularioConsultarOV.style.display = "block";
})

//Orden compra
registrarOC.addEventListener("click", function(){
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  agregarRegistroCompra.style.display = "block";
})

//Consultar Orden venta
consultarOC.addEventListener("click", function() {
  hideDashboard.style.display = "none";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";

  formularioConsultarOC.style.display = "block";
})


//Dashboard
mostrarDashboard.addEventListener("click", function mostrarFormulario() {
  hideDashboard.style.display = "block";
  agregarProducto.style.display = "none";
  agregarProveedor.style.display = "none";
  formularioConsultarProducto.style.display = "none";
  formularioConsultarProveedor.style.display = "none"; 
  agregarOrdenVenta.style.display = "none";
  formularioConsultarOV.style.display = "none";
  agregarRegistroCompra.style.display = "none";
  formularioConsultarOC.style.display = "none";
  agregarEvento.style.display = "none";
  formularioConsultarVenta.style.display = "none";
  agregarFormEmpleado.style.display = "none";
  formularioConsultarEmpleado.style.display = "none";
})



