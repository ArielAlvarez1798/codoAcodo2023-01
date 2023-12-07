document.addEventListener("DOMContentLoaded", function(){
    
    const addAutosForm = document.getElementById("addAutosForm");
    const parrafoAlerta = document.createElement("p");
    const marcaElement = document.getElementById("marca");
    const modeloElement = document.getElementById("modelo");
    const nacionalidadElement = document.getElementById("nacionalidad");
    const periodoElement = document.getElementById("periodo");
    const potenciaElement = document.getElementById("potencia");
    const aceleracionElement = document.getElementById("aceleracion");
    const velocidadElement = document.getElementById("velocidad");
    const precioElement = document.getElementById("precio");

    
    const imageElement = document.getElementById("imagen");
    const imagenPreview = document.getElementById("imagenPreview");
    const imagenContainer = document.getElementById("imagenContainer");
    

    addAutosForm.addEventListener("submit",function(e){
        e.preventDefault();
        
        const datos = new FormData();

        datos.append("action","add");
        datos.append("marca",marcaElement.value);
        datos.append("modelo",modeloElement.value);
        datos.append("nacionalidad",nacionalidadElement.value);
        datos.append("periodo",periodoElement.value);
        datos.append("potencia",potenciaElement.value);
        datos.append("aceleracion",aceleracionElement.value);
        datos.append("velocidad",velocidadElement.value);
        datos.append("precio",precioElement.value);
        datos.append("imagen",imageElement.files[0]);
        
        fetch("/app/autos", {
            method: "POST",
            body: datos
        })
            .then(response => response.json())
            .then(data=>{
                parrafoAlerta.textContent = data.message;
                addAutosForm.appendChild(parrafoAlerta);
                
                 
                setTimeout(() => {
                    parrafoAlerta.remove();
                    marcaElement.value="";
                    modeloElement.value="";
                    nacionalidadElement.value="";
                    periodoElement.value="";
                    potenciaElement.value="";
                    aceleracionElement.value="";
                    velocidadElement.value="";
                    precioElement.value="";
                    imagenContainer.classList.add("d-none");
                }, 3000);
            })

    });

    imageElement.addEventListener("change", function(){
       
        const selectedImage = imageElement.files[0];

        if (selectedImage){
            const reader = new FileReader();
            reader.onload = function(e){
                imagenPreview.src = e.target.result;
                imagenContainer.classList.remove("d-none")
            };

            reader.readAsDataURL(selectedImage);
        }else{
            imagenPreview.src="";
           
        }
    });
});