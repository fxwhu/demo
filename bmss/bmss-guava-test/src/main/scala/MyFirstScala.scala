/**
  * Created by fengxuan1 on 2017/4/25.
  */
object MyFirstScala {

  def main(args: Array[String]): Unit = {
    var hello = "Hello World";



    var res = math.sqrt(3);
    res = math.pow(res, 2);

    var biggerNum = 3.max(4);
    println(res);
    println(biggerNum);


    var testString = "testtaqqw";
    var firstChar = testString.charAt(0)
    var lastChar = testString.last;

    println(firstChar);

    println(lastChar);



    var distance = {var x = 3; var y = 4; math.sqrt(x* x + y * y)}

    println(distance)
  }

}
