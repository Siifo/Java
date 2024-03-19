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
  
  
})



