package learn

import edu.arizona.sista.learning.RVFDatum
import edu.arizona.sista.processors.{Document, Sentence}
import edu.arizona.sista.struct.{Counter, Interval}


// examples here: https://github.com/clulab/reach/blob/0334ce872734c7fd459266f4eefd43eeb139516b/src/main/scala/edu/arizona/sista/assembly/relations/classifier/FeatureExtractor.scala
object FeatureExtractor {

  val sep = ";;;"

  def mkRVFDatum(doc: Document, label: String = "None"): RVFDatum[String, String] = {

    val df = new Counter[String]()
    val features = mkFeatures(doc)
    // get counts of each feature
    features.foreach(f => df.incrementCount(f))

    new RVFDatum[String, String](label, df)
  }

  def mkFeatures(doc: Document): Seq[String] = {
    // TODO: NER features
    // TODO: ngram token features
    // TODO: syntax features
    // TODO: discourse features
    ???
  }

  def surfaceFeatures(s: Sentence): Seq[String] = ???

  def syntaxFeatures(s: Sentence): Seq[String] = ???

  // TODO: consider a different signature (ex. s1, s2)
  def discourseFeatures(doc: Document): Seq[String] = ???

  def ngrams(toks: Seq[String], n: Int): Seq[String] = n match {
    case noNgrams if noNgrams > toks.size => Nil
    case _ =>
      for {
        i <- 0 to (toks.size - n)
        start = i
        end = i + n
        ngram = toks.slice(start, end).mkString(" ")
      } yield ngram
  }

  def ngrams(toks: Seq[String], startN: Int, stopN: Int): Seq[String] = {
    val grams = for {
      n <- startN to stopN
    } yield ngrams(toks, n)
    grams.flatten
  }

}
