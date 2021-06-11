export const childRoutes = [
    {
        path: 'dashboard',
        loadChildren: () => 
            import('./dashboard/dashboard.module').then (m => m.DashboardModule),
        data: {icon: 'dashboard' , text: 'Dashboard Administrador'}

    },

    {
        path: 'gestionUsuarios',
        loadChildren: () => 
             import('./dashboard/dashboard.module').then (m => m.DashboardModule),
        data: {icon: 'group' , text: 'Gestión de Usuarios'}

    },

    {
        path: 'notificaciones',
        loadChildren: () => 
             import('./dashboard/dashboard.module').then (m => m.DashboardModule),
        data: {icon: 'notifications' , text: 'Notificaciones'}

    },

    {
        path: 'promociones',
        loadChildren: () => 
             import('./dashboard/dashboard.module').then (m => m.DashboardModule),
        data: {icon: 'sms' , text: 'Promociones'}

    },

    {
        path: 'catalogo',
        loadChildren: () => 
             import('./dashboard/dashboard.module').then (m => m.DashboardModule),
        data: {icon: 'shopping_cart' , text: 'Gestión Catálogo'}

    },

]