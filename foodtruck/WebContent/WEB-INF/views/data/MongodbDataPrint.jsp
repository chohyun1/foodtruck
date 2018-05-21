<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>몽고디비내용 출력</title>
<script src="http://code.highcharts.com/highcharts.js"></script>
<script src="http://code.highcharts.com/modules/exporting.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">



$(function () { 
    var myChart = Highcharts.chart('container1', {
        chart: {
            type: 'line'
        },
        title: {
            text: '서울지역 총 매출금액(월별)[금액:억원]'
        },
        subtitle: {
            text: 'Modified by 유태선',
            x: -20
        },
        xAxis: {
        	title: {
                text: '연도-월'
            },
            categories:  ['2016-11', '2016-12', '2017-01', '2017-02', '2017-03', '2017-04', '2017-05', '2017-06', '2017-07', '2017-08']
        },
        yAxis: {
            title: {
                text: '총 매출 금액'
            },
            plotLines: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        series: [{
            name: '서울전체',
            data: [14481,15652,17197,16785,14224,16642,16262,16424,16176,14945]
        }],
        
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        tooltip: {
            valueSuffix: '억원'
        }
    });
});


$(function () { 
    var myChart = Highcharts.chart('container2', {
        chart: {
            type: 'bar'
        },
        title: {
            text: '강남지역 총 매출금액(도로명별)[금액:억원]'
        },
        subtitle: {
            text: 'Modified by 유태선',
            x: -20
        },
        xAxis: {
            categories: ['강남대로', '봉은사로', '논현로', '언주로', '선릉로', '삼성로', '남부순환로']
        },
        yAxis: {
            title: {
                text: '총 매출 금액'
            },
            bar: [{
                value: 0,
                width: 1,
                color: '#808080'
            }]
        },
        series: [{
            name: '강남구',
            data: [593,547,1945,206,465,478,1470]
        }],
        
        legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        tooltip: {
            valueSuffix: '억원'
        }
    });
});

$(function () { 
	var myChart = Highcharts.chart('container3', {
	    title: {
	        text: '요일별 강남 유동인구(도로명별)[단위:명]'
	    },
	    subtitle: {
            text: 'Modified by 유태선',
            x: -20
        },legend: {
            layout: 'vertical',
            align: 'right',
            verticalAlign: 'middle',
            borderWidth: 0
        },
        tooltip: {
            valueSuffix: '명'
        },
	    xAxis: {
	        categories: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일']
	    },
	    labels: {
	        items: [{
	            html: ' ',
	            style: {
	                left: '50px',
	                top: '18px',
	                color: (Highcharts.theme && Highcharts.theme.textColor) || 'black'
	            }
	        }]
	    },
	    series: [{
	        type: 'column',
	        name: '강남대로',
	        data: [8241744, 8219798, 8597886, 8756846, 9108774,7586260,5925536]
	    }, {
	        type: 'column',
	        name: '봉은사로',
	        data: [72120, 73068, 78362, 78402, 74416, 48880, 37726]
	    }, {
	        type: 'column',
	        name: '논현로',
	        data: [1722861, 1729864, 1835897, 1837802, 1802405, 1414273, 1231583]
	    }, {
	        type: 'column',
	        name: '언주로',
	        data: [3948607, 4097361, 4299129, 4350034, 4212879, 2967616, 2354619]
	    }, {
	        type: 'column',
	        name: '선릉로',
	        data: [2382055, 2455803, 2576754, 2582679, 2517777,1904006,1548690]
	    }, {
	        type: 'column',
	        name: '삼성로',
	        data: [3704727, 3920327, 4048085, 4082035, 3989583,3099670,2554347]
	    }, {
	        type: 'column',
	        name: '남부순환로',
	        data: [38703159, 38885685, 40438846, 40808535, 41398555,40204530,36833078]
	    }, {
	        type: 'spline',
	        name: '유동인구 총량',
	        data: [58775273, 59381906, 61874959,62496333, 63104389,57225235,50485579],
	        marker: {
	            lineWidth: 2,
	            lineColor: Highcharts.getOptions().colors[3],
	            fillColor: 'white'
	        }
	    }, {
	        type: 'pie',
	        name: '각 도로명별 총 유동인구',
	        data: [{
	            name: '강남대로',
	            y: 56436844,
	            color: Highcharts.getOptions().colors[0] // Jane's color
	        }, {
	            name: '봉은사로',
	            y: 462974,
	            color: Highcharts.getOptions().colors[1] // John's color
	        }, {
	            name: '논현로',
	            y: 11574685,
	            color: Highcharts.getOptions().colors[3] // Joe's color
	        }, {
	            name: '언주로',
	            y: 26230245,
	            color: Highcharts.getOptions().colors[4] // Joe's color
	        }, {
	            name: '선릉로',
	            y: 15967764,
	            color: Highcharts.getOptions().colors[5] // Joe's color
	        }, {
	            name: '삼성로',
	            y: 25398774,
	            color: Highcharts.getOptions().colors[6] // Joe's color
	        }, {
	            name: '남부순환로',
	            y: 277272388,
	            color: Highcharts.getOptions().colors[7] // Joe's color
	        }],
	        center: [730, 20],
	        size: 100,
	        showInLegend: false,
	        dataLabels: {
	            enabled: false
	        }
	    }]
	})
});

</script>
<style type="text/css">
.data{
	margin: 0 auto;
}
</style>
</head>
<body>
<br><br><br>
<div class="data" id="container1" style="width:1000px; height:100%;"></div>
<br><br><br>
<div class="data" id="container2" style="width:1000px; height:100%;"></div>
<br><br><br>
<div class="data" id="container3" style="width:1000px; height:100%;"></div>
<br><br><br>
</body>
</html>