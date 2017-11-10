# README

## (1) Clean

gradle clean

## (2) Build

To build and run tests use the following command:

gradle build

### Test results

Open the following file:
build\reports\tests\test\index.html


## (2) Run Test Program

To run a test programming supplying a custom string as a stream parameter use the following command:

gradle run -PrunArgs="string parameter"

e.g:

gradle run -PrunArgs="aAbBABacafe"

