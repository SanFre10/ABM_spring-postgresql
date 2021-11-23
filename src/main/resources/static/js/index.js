$(".editBtn").click(function (event) {
    row = document.getElementById("row" + event.target.id);
    var values = new Array();
    for (let i = 0; i < row.children.length - 1; i++) {
        i != 0 ? row.children[i].toggleAttribute("contenteditable") : null;
        values[i] = row.children[i].innerText;
    }
    if ($(this).html().includes("edit")) $(this).html("<span class='iconify' data-icon='fluent:save-16-regular'></span>");
    else {
        $(this).html("<span class='iconify' data-icon='ci:edit'></span>");
        request("/add", { id: parseInt(values[0]), nombre: values[1], apellido: values[2], telefono: values[3], email: values[4] }, "POST");
    }
});

$("#submitBtn").click(function () {
    var values = $(".input").map(function () {
        return $(this).val();
    });
    request("/add", { nombre: values[0], apellido: values[1], telefono: values[2], email: values[3] }, "POST");
});

request = (url, data, type) => {
    for (let key in data) {
        console.log(typeof data[key], data[key], data[key].length);
        if (!data[key] || data[key] == "\n") {
            $("#error").show();
            return;
        }
    }
    $.ajax({
        type: type,
        url: url,
        data: JSON.stringify(data),
        contentType: "application/json",
        beforeSend: function () {
            $("#request-overlay").show();
        },
        success: function () {
            $("#request-overlay").hide();
            window.location.href = "/";
        },
        error: function (data) {
            $("#request-overlay").hide();
            console.log(data);
        },
    });
};
