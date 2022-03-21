const sign_in_bnt = document.querySelector("#sign-in-bnt");
const sign_up_bnt = document.querySelector("#sign-up-bnt");
const container = document.querySelector(".container");

sign_up_bnt.addEventListener('click',() =>
{
    container.classList.add("sign-up-mode")
}
);

sign_in_bnt.addEventListener('click',() =>
{
    container.classList.remove("sign-up-mode")
}
);
