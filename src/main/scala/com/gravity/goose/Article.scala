/**
 * Licensed to Gravity.com under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Gravity.com licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.gravity.goose

import images.Image
import org.jsoup.nodes.{ Element, Document }
import java.util.Date
import scala.collection._
import scala.reflect.BeanProperty

/**
 * Created by Jim Plush
 * User: jim
 * Date: 8/14/11
 */

class Article {

  /**
   * title of the article
   */
  @BeanProperty
  var title: String = null

  /**
   * stores the lovely, pure text from the article, stripped of html, formatting, etc...
   * just raw text with paragraphs separated by newlines. This is probably what you want to use.
   */
  @BeanProperty
  var cleanedArticleText: String = ""

  /**
   * meta description field in HTML source
   */
  @BeanProperty
  var metaDescription: String = ""

  /**
   * meta keywords field in the HTML source
   */
  @BeanProperty
  var metaKeywords: String = ""

  /**
   * The canonical link of this article if found in the meta data
   */
  @BeanProperty
  var canonicalLink: String = ""

  /**
   * holds the domain of this article we're parsing
   */
  @BeanProperty
  var domain: String = ""

  /**
   * holds the top Element we think is a candidate for the main body of the article
   */
  @BeanProperty
  var topNode: Element = null

  /**
   * holds the top Image object that we think represents this article
   */
  @BeanProperty
  var topImage: Image = new Image

  /**
   * holds a set of tags that may have been in the artcle, these are not meta keywords
   */
  @BeanProperty
  var tags: Set[String] = null

  /**
   * holds a map of any links -> link text in the article
   */
  @BeanProperty
  var links: Map[String, String] = null

  /**
   * holds a list of any movies we found on the page like youtube, vimeo
   */
  @BeanProperty
  var movies: List[Element] = Nil

  /**
   * stores the final URL that we're going to try and fetch content against, this would be expanded if any
   * escaped fragments were found in the starting url
   */
  @BeanProperty
  var finalUrl: String = "";

  /**
   * stores the MD5 hash of the url to use for various identification tasks
   */
  @BeanProperty
  var linkhash: String = "";

  /**
   * stores the RAW HTML straight from the network connection
   */
  @BeanProperty
  var rawHtml: String = ""

  /**
   * the JSoup Document object
   */
  @BeanProperty
  var doc: Document = null

  /**
   * this is the original JSoup document that contains a pure object from the original HTML without any cleaning
   * options done on it
   */
  @BeanProperty
  var rawDoc: Document = null

  /**
   * Sometimes useful to try and know when the publish date of an article was
   */
  @BeanProperty
  var publishDate: Date = null

  /**
   * A property bucket for consumers of goose to store custom data extractions.
   * This is populated by an implementation of {@link com.gravity.goose.extractors.AdditionalDataExtractor}
   * which is executed before document cleansing within {@link com.gravity.goose.CrawlingActor#crawl}
   * @return a {@link Map Map&lt;String,String&gt;} of property name to property vaue (represented as a {@link String}.
   */
  @BeanProperty
  var additionalData: Map[String, String] = Map.empty
}