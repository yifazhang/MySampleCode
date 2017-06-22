function Photo() {
    this.hide = function () {
        //定位图片
        var img = document.images[0];
        img.style.visibility = "hidden";
    }
    this.show = function (){
        var img = document.images[0];
        img.style.visibility = "visible";
    }
}

function $(str) {
    var type = typeof(str);
    if ("string" == type) {
        var first = str.substring(0,1);
        if ("#" == first) {
            var end = str.substring(1,str.length);
            var element = document.getElementById(end);
            return element;
        }
    }
}