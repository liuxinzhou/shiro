#技术点记录

1、mapper的xml文件，开头不可以有任何空格和换行

2、扫描mapper类必须要有这句否则找不到

    @MapperScan("com.shiro.demoshiro.mapper")
