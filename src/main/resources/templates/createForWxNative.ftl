<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <title>支付</title>
</head>
<div id="myQrcode"></div>
<div id="orderId" hidden>${orderId}</div>
<div id="returnUrl" hidden>${returnUrl}</div>
<body>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/1.5.1/jquery.min.js"></script>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery.qrcode/1.0/jquery.qrcode.min.js"></script>
    <script>
        jQuery('#myQrcode').qrcode({
            text	: "${codeUrl}}"
        });
        $(function () {
            setInterval(function () {
                console.log('開始查詢支付狀態...')
                $.ajax({
                    url: '/pay/queryByOrderId',
                    data: {
                        'orderId': $('#orderId').text()
                    },
                    success: function (result) {
                        console.log(result)
                        if (result.platformStatus != null
                            && result.platformStatus === 'SUCCESS' ) {
                                location.href = $('#returnUrl').text()
                        }
                    },
                    error: function (result) {
                        alert(result)
                    }
                })
            }, 2000)
        });
    </script>
</body>
</html>