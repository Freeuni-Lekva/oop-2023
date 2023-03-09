# 02

კლასი რომელიც გვაძლევს საშუალებას რომ გადავიყვანოთ რიცხვები რომაული ჩანაწერიდან არაბულში და პირიქით.

# კომპილაცია

```shell
> javac *.java
```

# jar ფაილის შექმნა

```shell
> jar cmf Manifest.MF roman.jar  *.class
```

# jar ფაილის გაშვება

```shell
> java -jar roman.jar 1924
1924
MCMXXIV

> java -jar roman.jar MCMXXIV
1924
MCMXXIV
```