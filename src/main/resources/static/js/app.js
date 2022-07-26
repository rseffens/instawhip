/**
 * 
 */

const inpFile = document.getElementById("inpFile");   
const previewContainer = document.getElementById("imagePreview");
const previewImage = previewContainer.querySelector(".image-preview__image");
const previewDefaultText = previewContainer.querySelector(".image-preview__default-text")

inpFile.addEventListener("change", fucntion()); {
	const file = this.files[0];

    console.log(file);
}