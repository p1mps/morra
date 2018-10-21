(defproject morra "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[clj-sockets "0.1.0"]
                 [org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot morra.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
