document.addEventListener("DOMContentLoaded", function(){
    const autoCards = document.getElementById("autosCards");
    const autos = [];
    
    function loadAutosList(){        
        fetch("/app/autos?action=getAll")
                .then(response=> response.json())
                .then(data =>{
                    data.forEach(auto =>{
                       autos.push(auto)              
                       autoCards.innerHTML += `
                            <div class="col-md-3 mb-4 ident" data-book-id = "${auto.idauto}">
                                <div class="card h-100 animate-hover-card">
                                    <img src="data:image/jpeg;base64,${auto.imagenBase64}" class="card-img-top h-75" alt="Imagen Portada de Libro">
                                    <div class="card-body">
                                        <h5 class="card-title">${auto.modelo}</h5>
                                        <p class="card-text">${auto.marca}</p>
                                    </div>
                                </div>
                            </div>
                        `		
                    });
                });
    }
    
    function filterAutos(datoBuscar){        
        const autosFiltrados = autos.filter(autos=>{           
            return autos.marca.toLowerCase().includes(datoBuscar.toLowerCase());                       
        });

        autoCards.innerHTML = "";        
        autosFiltrados.forEach(auto =>{            
            const card = document.createElement("div");
            card.className = "cod-md-3 mb-4 ident";
            card.setAttribute("data-auto-id",auto.idauto)
            card.innerHTML = `
                <div class="card h-100 animate-hover-card">
                    <img src="data:image/jpeg;base64,${auto.imagenBase64}" class="card-img-top h-75" alt="Imagen de Portada">
                    <div class="card-body">
                        <h5 class="card-title">${auto.marca}</h5>
                        <p class="card-test"> ${auto.modelo}</p>
                    </div>
                </div>        
            `
            autoCards.appendChild(card);
        });

    }

    //evento que lanza el filtro de busqueda
    const searchForm = document.querySelector("form[role='search']");
    searchForm.addEventListener("submit",function(e){        
        e.preventDefault();
        const searchTerm = searchForm.querySelector("input[type='search']").value;        
        filterAutos(searchTerm);
    });

    loadAutosList();

});


