"use strict";
import {byId, toon, verberg} from "./util.js";
byId("toevoegen").onclick = async function(){
    verbergFouten();
    const naamInput = byId("naam");
    if(! naamInput.checkValidity()){
        toon("naamFout");
        naamInput.focus();
    }
    const prijsInput = byId("prijs");
    if(!prijsInput.checkValidity()){
        toon("prijsFout");
        prijsInput.focus();
    }
    const pizza = {
        naam: naamInput.value,
        prijs: Number(prijsInput.value)
    }
    voegToe(pizza);
};
function verbergFouten(){
    verberg("naamFout");
    verberg("prijsFout");
    verberg("storing");
}
async function voegToe(pizza){
    const response = await fetch("pizzas",
        {method: "POST",
            headers:{'Content-Type': "application/json"},
            body: JSON.stringify(pizza)
        });
    if(response.ok){
        window.location = "allepizzas.html";
    } else {
        toon("storing");
    }
}