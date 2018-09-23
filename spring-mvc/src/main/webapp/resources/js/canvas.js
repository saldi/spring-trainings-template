var testCanvas = (function (document) {

    var _canvas = null;

    var createCanvas = function (element) {
        _canvas = new fabric.Canvas(element, {
            backgroundColor: 'rgb(100,100,200)',
            selectionColor: 'blue',
            selectionLineWidth: 2
        });
        _canvas.setHeight(400);
        _canvas.setWidth(400);
        _canvas.renderAll();
    }

    var addRect = function () {
        var rect = new fabric.Rect({
            left: 100,
            top: 100,
            fill: 'red',
            width: 50,
            height: 50
        });
        _canvas.add(rect);
    };

    $(function () {

    });

    var getCanvas = function () {
        return _canvas;
    }
    return {
        getCanvas: getCanvas,
        createCanvas: createCanvas,
        addRect: addRect
    }
        ;

})(document);