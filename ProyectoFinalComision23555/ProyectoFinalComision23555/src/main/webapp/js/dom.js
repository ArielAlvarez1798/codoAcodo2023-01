var TicketSeleccionados = new Array(3);
const ValorTicket = 200;
var cantidadTicket = 0;

/*accion sobre click selecciona tipo de ticket*/

const box01 = document.querySelector("#seleccionaTicket80");
const box02 = document.querySelector("#seleccionaTicket50");
const box03 = document.querySelector("#seleccionaTicket15");
const btn01 = document.querySelector("#btnResumen");
const btn02 = document.querySelector("#btnBorrar");
const lb01 = document.querySelector("#lbTotalCompra");
const tb01 = document.querySelector("#tbCantidad");
const tb02 = document.querySelector("#tbCorreo");
const tb03 = document.querySelector("#tbNombre");
const tb04 = document.querySelector("#tbApellido");
InicializaCompra();

function InicializaCompra(){
    TicketSeleccionados[0] = 0;
    TicketSeleccionados[1] = 0;
    TicketSeleccionados[2] = 0;
    tb01.value = 0;
    tb02.value="";
    tb03.value="";
    tb04.value="";
    cantidadTicket = 0;
};

function AcumulaTicket(TipoTicket){
    if (TipoTicket=="80"){
        TicketSeleccionados[0] ++ ;
    }
    if (TipoTicket=="50"){
        TicketSeleccionados[1] ++ ;
    }
    if (TipoTicket=="15"){
        TicketSeleccionados[2] ++ ;
    }
    cantidadTicket ++;
    tb01.value = cantidadTicket;
};

box01.addEventListener("click", function () {
    AcumulaTicket("80");
});
box02.addEventListener("click", function () {
    AcumulaTicket("50");
});
box03.addEventListener("click", function () {
    AcumulaTicket("15");
});

btn01.addEventListener("click",function(){
    let TotalCompra = 0
    if (TicketSeleccionados[0]>0){
        TotalCompra = TotalCompra + ((ValorTicket * TicketSeleccionados[0]) - 
        (((ValorTicket * TicketSeleccionados[0])*80)/100));
    }
    if (TicketSeleccionados[1]>0){
        TotalCompra = TotalCompra + ((ValorTicket * TicketSeleccionados[1]) - 
        (((ValorTicket * TicketSeleccionados[1])*50)/100));
    } 
    if (TicketSeleccionados[2]>0){
        TotalCompra = TotalCompra + ((ValorTicket * TicketSeleccionados[2]) - 
        (((ValorTicket * TicketSeleccionados[2])*15)/100));
    }    
    lb01.textContent = "Total a Pagar:$ " + TotalCompra;
   
})

btn02.addEventListener("click",function(){
    InicializaCompra();
    lb01.textContent = "Total a Pagar:$ "
})

tb02.addEventListener("change", function(event){
    valorObtenido = event.target.value;
  
    if (!valorObtenido.includes("@")){
        alert("No es una dirección de Mail Válido");
        event.target.value = "";
        document.getElementById("tbCorreo").focus();    //getElementById no use el #
    }else{
        event.target.value = valorObtenido.toUpperCase();
    }
    
    
})

tb03.addEventListener("change" , function(event){
    valorObtenido = event.target.value;
    event.target.value = valorObtenido.toUpperCase();
})
tb04.addEventListener("change" , function(event){
    valorObtenido = event.target.value;
    event.target.value = valorObtenido.toUpperCase();
})
