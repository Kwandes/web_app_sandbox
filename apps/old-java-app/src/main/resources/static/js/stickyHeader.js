function Sticky()
{
    $(document).ready(function() {
        var NavY = $('#StickyHeader').offset().top;
        var stickyNav = function(){
            var ScrollY = $(window).scrollTop();
            if (ScrollY > NavY) {
                $('#StickyHeader').addClass('stickyLogo');
            } else {
                $('#StickyHeader').removeClass('stickyLogo');
            } };
        stickyNav();
        $(window).scroll(function() {
            stickyNav(); }); });
}