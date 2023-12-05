document.addEventListener("DOMContentLoaded", function(){
    const autoCards = document.getElementById("autosCards");
    const autos = [];
    
    function loadAutosList(){        
        fetch("/app/autos?action=getAll")
                .then(response=> response.json())
                .then(data =>{
                    data.forEach(auto =>{
                       autos.push(auto)              
                       autosCards.innerHTML += `
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
    
    loadAutosList();
});


