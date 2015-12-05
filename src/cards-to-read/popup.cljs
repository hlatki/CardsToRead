(ns cards-to-read.popup
  (:require [khroma.runtime :as runtime]
            [khroma.log :as console]
            [cljs.core.async :refer [>! <!]])
  (:require-macros [cljs.core.async.macros :refer [go go-loop]]))

;;(defn success-function []
;;      (console/log "Authorization was successful :)"))
;;
;;(defn failure-function[]
;;      (console/log "Authorization failed :("))
;;(defn trello-auth []
;;      (.authorize js/Trello
;;                  {name: "CardsToRead",
;;                   scope: {
;;                           read: true,
;;                           write: true },
;;                   expiration: "never",
;;                   success-function,
;;                   failure-function}))
;;(defn sayfuck [] (console/log "fuckfuckfuckfuck"))
;;(defn init []
;;  (let [bg (runtime/connect)]
;;    (go (>! bg :lol-i-am-a-popup)
;;        ;;(console/log "(popup) Background said: " (<! bg)))))
;;        (console/log "(popup) Background said: " (<! bg)))))

(defn process-message [message]
      (console/log "(in popup): ")
      (console/log message))

(defn init []
      (let [messages (runtime/on-message)]
           (go-loop []
                    (when-let [message (<! messages)]
                              (process-message message)
                              (recur)))))

