import { createRouter, createWebHistory } from 'vue-router'
import AllSessionView from "@/views/AllSessionView.vue";
import TicketView from "@/views/TicketView.vue";
import SeatView from "@/views/SeatView.vue";
import SuggestMoviesView from "@/views/SuggestMoviesView.vue";

const router = createRouter({
    history: createWebHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/session/:sessionId',
            name: 'session',
            component: () => import('../views/SessionView.vue'),
            props: true,
            children: [
                {
                    path: 'ticket',
                    name: 'ticket',
                    component: TicketView,
                    props: true
                },
                {
                    path: 'seats',
                    name: 'seats',
                    component: SeatView,
                    props: route => ({ sessionId: route.params.sessionId, ticketNr: route.query.ticketNr })
                }
            ]
        },
        {
            path: '/:profileId',
            name: 'suggestedMovies',
            component: SuggestMoviesView,
            props: true,
        },
        {
            path: '/',
            name: 'sessions',
            component: AllSessionView
        },
    ]
})

export default router
