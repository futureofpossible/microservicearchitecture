#web应用的自动化打包和发布
#自动化测试和持续集成、发布
#FROM 指定基础镜像，一切从这里开始构建
#MAINTAINER	维护者作者，姓名+邮箱
#RUN 镜像构建的时候需要运行的命令
#ADD COPY命令用于将宿主机器上的的文件复制到镜像内，如果目的位置不存在，Docker会自动创建
#WORKDIR 配置镜像的工作目录
#VOLUME	挂载的目录
#EXPOSE	指定暴露端口 适用于设置容器对外映射的容器端口号
#CMD 用于容器启动时需要执行的命令，CMD在Dockerfile中只能出现一次，如果出现多个，那么只有最后一个会有效。
#ENTRYPOINT	指定这个容器启动的时候要运行的命令，可以追加命令 docker容器启动时执行的命令
#ONBUILD 用于配置当前所创建的镜像作为其它新创建镜像的基础镜像时，所执行的操作指令。
#COPY 类似ADD，将我们的文件拷贝到镜像中
#ENV 构建的时候用于设置容器的环境变量
#USER
FROM java:8-jre
MAINTAINER zhangyibing7@huawei.com
VOLUME /tmp
ADD ./target/springcloud-eureka-1.0.0-SNAPSHOT.jar springcloud-eureka.jar
#CMD ["java", "-Xmx200m", "-jar", "springcloud-eureka.jar"]
RUN bash -c 'touch /springcloud-eureka.jar'
EXPOSE 8080

#docker build -t springcloud-eureka 制作镜像
#docker images 查看镜像
#docker run -d -p 8001:8080 springcloud-eureka  让容器在后台运行 端口映射 启动容器
#Docker Compose服务编排