import org.apache.spark.{SparkContext, SparkConf}


package object learn {

  // pipelines: http://spark.apache.org/docs/1.4.1/ml-guide.html#example-pipeline
  val appName = "bio-lda"
  val conf = new SparkConf().setAppName(appName).setMaster("local")
  val sc = new SparkContext(conf)

}
