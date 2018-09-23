var savePicture = function (name, canvas) {
    var saveData = JSON.stringify(canvas);
    $.ajax({
        contentType:"application/json",
        data: saveData,
        url: '/config/' + name,
        type: 'PUT',
        success: function (result) {
            alert("dane zapisane")
        }, error: function () {
            alert("błąd przy zapisie danych");
        }
    });
};

var loadPicture = function (name, canvas) {
    $.get("/config/" + name, function (config) {
        canvas.loadFromJSON(config);
    })
};

var addCircle = function (canvas) {
    var circle = new fabric.Circle({
        left: 150,
        top: 150,
        fill: 'green',
        radius: 50,
    });
    canvas.add(circle);
}

var addRect = function (canvas) {
    var rect = new fabric.Rect({
        left: 100,
        top: 100,
        fill: 'red',
        width: 50,
        height: 50
    });
    canvas.add(rect);
}
