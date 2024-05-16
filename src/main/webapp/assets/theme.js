/**
 * 你可以设置theme的值，来控制界面的主题
 */
$(function () {
    //主题有三种，默认是默认主题
    //默认：default
    //暗黑：dark
    //幽兰：translucent
    let theme = "default";
    //背景图片
    // 黑夜：dark
    // 舞女，gray
    // 禅，chan
    // 事事顺心，green
    // 雪，snow
    // 沙漠，shamo
    let loginBgName = "chan";
    let mainBgName = '';

    $("body").attr("data-theme", theme);
    //登录注册背景
    if (loginBgName !== '')
        $(".lyear-wrapper").attr("style", `background-image: url(${ctx}/assets/images/${loginBgName}.jpg);background-size: cover;`);
    //页面背景
    if (mainBgName !== '')
        $("body").attr("style", `background-image: url(${ctx}/assets/images/${mainBgName}.jpg);background-size: cover;`);

})
