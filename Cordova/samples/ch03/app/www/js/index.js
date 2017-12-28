var app = {
    // Application Constructor
    initialize: function() {
        this.bindEvents();
    },
    // Bind Event Listeners
    bindEvents: function() {
        document.addEventListener('deviceready', this.onDeviceReady, false);
    },
    // deviceready Event Handler
    onDeviceReady: function() {
        $('#device-not-ready').hide();
        $('#device-ready').show();

        $('#camera-call').click(function(){
            navigator.camera.getPicture(app.onSuccess, app.onFail, { quality: 50,
                destinationType: Camera.DestinationType.DATA_URL
            });
        });
    },
    onSuccess : function(imageData){
        var image = $('#image');
        image.attr('src',"data:image/jpeg;base64," + imageData);
    },
    onFail : function(message) {
        alert('Failed because: ' + message);
    }
};
app.initialize();