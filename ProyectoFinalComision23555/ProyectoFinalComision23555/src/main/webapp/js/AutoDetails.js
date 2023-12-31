document.addEventListener("DOMContentLoaded", function(){
   
    const queryParams = new URLSearchParams(window.location.search);
    const autoDetailId = {
        id: queryParams.get("idAuto")        
    }
        
    const autoDetailContainer = document.getElementById("autoDetails");
    const btnEliminarElement = document.getElementById("btnEliminar");
    const btnModificaElement = document.getElementById("btnModificar");
    const btnGuardarElement = document.getElementById("btnGuardar");
    const btnContainerElement = document.getElementById("btnContainer");
    
    let objetoAuto= {
        idauto: 0,
        marca: "",
        modelo: "",
        nacionalidad: "",
        periodo: "",
        potencia: "",
        aceleracion: "",
        velocidad: "",
        precio: 0,
        imagen: ""
    }
    
    function loadAuto(){
        
        fetch(`/app/autos?action=getById&idAuto=${autoDetailId.id}`)      
                .then(response => response.json())
                .then(data => {
                    autoDetailContainer.innerHTML +=`
                        <div class="col-md-6 text-center">
                            <div class="clearfix">
                                <img src="data:image/jpeg;base64,${data.imagenBase64}" class="my-4" style="width: 75%" alt="imagen de auto"/>
                            </div>
                        </div>
                        <div class="card-body col-md-6"> 
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">
                                    <h2 class="card-title">${data.marca} ${data.modelo}</h2>
                                </li>
                                <li class="list-group-item">Marca: ${data.marca}</li>
                                <li class="list-group-item">Modelo: ${data.modelo}</li>
                                <li class="list-group-item">Nacionalidad: ${data.nacionalidad}</li>
                                <li class="list-group-item">Periodo: ${data.periodo}</li>
                                <li class="list-group-item">Potencia: ${data.potencia}</li>
                                <li class="list-group-item">Aceleración: ${data.aceleracion}</li>                        
                                <li class="list-group-item">Velocidad: ${data.velocidad}</li>                        
                                <li class="list-group-item">
                                    <h5>Precio: ${data.precio}</h5>
                                </li>                        
                            </ul>    
                        </div>
                    `;
                    
                    objetoAuto.idauto = data.idAuto;
                    objetoAuto.marca = data.marca;
                    objetoAuto.modelo = data.modelo;
                    objetoAuto.nacionalidad = data.nacionalidad;
                    objetoAuto.periodo = data.periodo;
                    objetoAuto.potencia = data.potencia;
                    objetoAuto.aceleracion = data.aceleracion;
                    objetoAuto.velocidad = data.velocidad;
                    objetoAuto.precio = data.precio;
                    objetoAuto.imagen = data.imagen;
                    
                })
    }
    
    btnEliminarElement.addEventListener('click',function(){        
        let confirma = window.confirm("Desea Eliminar la Ficha Seleccionada?");
        if(confirma){
            fetch(`/app/autos?action=delete&idAuto=${autoDetailId.id}`,{
                method:"DELETE"
            })

            .then(response => response.json())
            .then(data => {               
                    if(data.success){
                       window.location.href=`/app/index.html`; 
                    }
             });
         };
    });
    
    btnModificaElement.addEventListener('click', function(){
        
        btnModificaElement.classList.add('d-none');
        btnEliminarElement.classList.add('d-none');
        btnGuardarElement.classList.remove("d-none");
        
        autoDetailContainer.innerHTML = `
                    <div class="col-md-6 text-center">
                            <div class="clearfix">
                                <img src="data:image/jpeg;base64,${objetoAuto.imagen}" class="my-4" style="width: 75%" alt="imagen de auto"/>
                            </div>
                    </div>
                    <div class="card-body col-md-6">
                        <form class="mb-4" id="updateAutosForm" enctype="multipart/form-data">
                              <div class="card-body">
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-floating my-3">
                                            <input type="text" class="form-control" name="marca" id="marca" value=${objetoAuto.marca} required/>
                                            <label for="marca">Marca</label>
                                        </div>
                                        <div class="form-floating my-3">
                                            <input type="text" class="form-control" name="modelo" id="modelo" value=${objetoAuto.modelo} required/>
                                            <label for="modelo">Modelo</label>
                                        </div>    
                                        <div class="form-floating my-3">
                                            <input type="text" class="form-control" name="nacionalidad" id="nacionalidad" value=${objetoAuto.nacionalidad} required/>
                                            <label for="nacionalidad">Nacionalidad</label>
                                        </div>      
                                        <div class="form-floating my-3">
                                            <input type="text" class="form-control" name="periodo" id="periodo" value=${objetoAuto.periodo} required/>
                                            <label for="periodo">Periodo</label>
                                        </div>                                            
                                        <div class="form-floating my-3">
                                            <input type="text" class="form-control" name="potencia" id="potencia" value=${objetoAuto.potencia} required/>
                                            <label for="potencia">Potencia</label>
                                        </div>  
                                        <div class="form-floating my-3">
                                            <input type="text" class="form-control" name="aceleracion" id="aceleracion" value=${objetoAuto.aceleracion} required/>
                                            <label for="aceleracion">Aceleracion</label>
                                        </div>     
                                        <div class="form-floating my-3">
                                            <input type="text" class="form-control" name="velocidad" id="velocidad" value=${objetoAuto.velocidad} required/>
                                            <label for="velocidad">Velocidad</label>
                                        </div>  
                                        <div class="form-floating my-3">
                                            <input type="number" class="form-control" name="precio" id="precio" value=${objetoAuto.precio} required/>
                                            <label for="precio">Precio</label>
                                        </div>                                                                                        
                                    </div>
                                    
                                </div>
                                
                            </div>                        
                        </form>
                    </div>
        `
            
    });
    
    btnGuardarElement.addEventListener('click', function(e){
       e.preventDefault();
       
       const formulario = new FormData();
       
       formulario.append("action","update");
       formulario.append("id",autoDetailId.id);
       formulario.append("marca",document.getElementById("marca").value);
       formulario.append("modelo",document.getElementById("modelo").value);
       formulario.append("nacionalidad",document.getElementById("nacionalidad").value);
       formulario.append("periodo",document.getElementById("periodo").value);
       formulario.append("potencia",document.getElementById("potencia").value);
       formulario.append("aceleracion",document.getElementById("aceleracion").value);
       formulario.append("velocidad",document.getElementById("velocidad").value);
       formulario.append("precio",document.getElementById("precio").value);
       formulario.append("imagen",objetoAuto.imagen);
       
             
       fetch(`/app/autos?action=update`,{
          method:"POST",
          body: formulario
       })       
            .then(response => response.json())
            .then(data => { 
                window.alert("Modificación realizada correctamente")
                if(data.success){
                   window.location.href=`/app/index.html`; 
                }
         });
                     
             
    });
    
    loadAuto();
});
