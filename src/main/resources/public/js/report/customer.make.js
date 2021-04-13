layui.use(['layer','echarts'],function(){
        $ = layui.jquery,
        echarts = layui.echarts;
        //折线图
        $.ajax({
            type:"post",
            url:ctx+"/customer/countCustomerMake",
            dataType:"json",
            success:function (res) {
                var myChart = echarts.init(document.getElementById('make'));
                option = {
                    xAxis:{
                        type:"category",
                        data:res.data1
                    },
                    yAxis:{
                        type:'value'
                    },
                    series:[{
                        data:res.data2,
                        type:"line"
                    }]
                }
                myChart.setOption(option);
            }
        });
            //饼状图
            $.ajax({
                type:"post",
                url:ctx+"/customer/countCustomerMake02",
                dataType:"json",
                success:function (res) {
                    var myChart = echarts.init(document.getElementById('make02'));
                    option = {
                        title: {
                            text: '客户构成分析-饼图',
                            subtext: '',
                            left: 'center'
                        },
                        tooltip: {
                            trigger: 'item',
                            formatter: '{a} <br/>{b} : {c} ({d}%)'
                        },
                        legend: {
                            left: 'center',
                            top: 'bottom',
                            data: res.data1
                        },
                        toolbox: {
                            show: true,
                            feature: {
                                mark: {show: true},
                                dataView: {show: true, readOnly: false},
                                restore: {show: true},
                                saveAsImage: {show: true}
                            }
                        },
                        series: [
                            {
                                name: '半径模式',
                                type: 'pie',
                                radius: [20, 140],
                                center: ['25%', '50%'],
                                roseType: 'radius',
                                itemStyle: {
                                    borderRadius: 5
                                },
                                label: {
                                    show: false
                                },
                                emphasis: {
                                    label: {
                                        show: true
                                    }
                                },
                                data: res.data2


                            },
                            {
                                name: '面积模式',
                                type: 'pie',
                                radius: [20, 140],
                                center: ['75%', '50%'],
                                roseType: 'area',
                                itemStyle: {
                                    borderRadius: 5
                                },
                                data: res.data2
                            }
                        ]
                    };
                    myChart.setOption(option);
                }
            })
});
