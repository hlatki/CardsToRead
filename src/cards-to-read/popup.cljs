(ns cards-to-read.popup
  (:require [khroma.runtime :as runtime]
            [khroma.log :as console]
            [cljs.core.async :refer [>! <!]])
  (:require-macros [cljs.core.async.macros :refer [go]]))

(defn trello-auth []
      (.authorize js/Trello
                  {name: "CardsToRead",
                   scope: {
                           read: true,
                           write: true },
                   expiration: "never",
                   (console/log "Authorization was successful :)"),
                   (console/log "Authorization failed :("),
                   }))
(defn init []
      (trello-auth)
  (let [bg (runtime/connect)]
    (go (>! bg :lol-i-am-a-popup)
        (console/log "Background said: " (<! bg)))))


