(ns cards-to-read.content
  (:require [khroma.runtime :as runtime]
            [khroma.log :as console]
            [cljs.core.async :refer [>! <!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

;;(defn init []
;;      (console/log "connnnntent script cjklhgfsdfghjkl")
;;  (let [bg (runtime/connect)]
;;    (go (>! bg :lol-i-am-a-content-script)
;;        (>! bg (.-location js/document))
;;        (console/log "(content script) Background said: " (<! bg)))))

(defn handle-response [response]
      (console/log "(in content)")
      (console/log response))
(defn init []
      (runtime/send-message
        {:message-data "xx" :something-else "yyy"}
        {:extensionId "some.other.extension"
         :responseCallback
                      (fn [response]
                          (handle-response response))}))
